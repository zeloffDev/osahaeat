package com.zeloff.osahaeat.service;

import com.zeloff.osahaeat.dto.RatingRestaurantDto;
import com.zeloff.osahaeat.dto.RestaurantDto;
import com.zeloff.osahaeat.entity.RatetingRestourant;
import com.zeloff.osahaeat.entity.Restourant;
import com.zeloff.osahaeat.repository.RestaurantRepository;
import com.zeloff.osahaeat.service.imp.FilesStorageServiceImp;
import com.zeloff.osahaeat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    FilesStorageServiceImp filesStorageServiceImp;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public boolean insertRestaurant(
            MultipartFile file,
            String title,
            String sub_title,
            String description,
            int is_free,
            String address,
            String open_date) {
        boolean isSuccess = false;
        try {
            boolean isSuccessSaveFile = filesStorageServiceImp.save(file);
            boolean isFree = is_free == 1;
            if (isSuccessSaveFile) {
                Restourant restourant = new Restourant();
                restourant.setImage(file.getOriginalFilename());
                restourant.setTitle(title);
                restourant.setSubTitle(sub_title);
                restourant.setDescription(description);
                restourant.setFree(isFree);
                restourant.setAddress(address);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = simpleDateFormat.parse(open_date);
                restourant.setOpenDate(date);
                restaurantRepository.save(restourant);
                isSuccess = true;
            }
        } catch (Exception e) {

        }

        return isSuccess;
    }

    @Override
    public List<RestaurantDto> getListRestaurant(int page, int pageSize) {
        List<RestaurantDto> listRestaurantDto = new ArrayList<RestaurantDto>();
        try {
            PageRequest pageRequest = PageRequest.of(page , pageSize);
            Page<Restourant> listRestaurant = restaurantRepository.findAll(pageRequest);

            for (Restourant restaurant : listRestaurant) {
                Set<RatetingRestourant> listRatetingRestourant = restaurant.getListRatetingRestourant();
                Set<RatingRestaurantDto> listRatingRestaurantDto = getRatingRestaurantDto(listRatetingRestourant);
                RestaurantDto restaurantDto = new RestaurantDto();
                restaurantDto.setId(restaurant.getId());
                restaurantDto.setFree(restaurant.isFree());
                restaurantDto.setImage(restaurant.getImage());
                restaurantDto.setRating(getRating(listRatetingRestourant));
                restaurantDto.setTitle(restaurant.getTitle());
                restaurantDto.setSubTitle(restaurant.getSubTitle());
                restaurantDto.setListRatingRestaurantDto(listRatingRestaurantDto);
                listRestaurantDto.add(restaurantDto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listRestaurantDto;
    }

    private static Set<RatingRestaurantDto> getRatingRestaurantDto(Set<RatetingRestourant> listRatetingRestourant) {
        Set<RatingRestaurantDto> listRatingRestaurantDto = new HashSet<>();
        for (RatetingRestourant rating : listRatetingRestourant) {
            RatingRestaurantDto ratingRestaurantDto = new RatingRestaurantDto();
            ratingRestaurantDto.setRatePoin(rating.getRatePoin());
            ratingRestaurantDto.setContent(rating.getContent());
            ratingRestaurantDto.setId(rating.getId());

            listRatingRestaurantDto.add(ratingRestaurantDto);
        }
        return listRatingRestaurantDto;
    }

    private double getRating(Set<RatetingRestourant> listRatetingRestourant) {
        double rating = 0;
        if (listRatetingRestourant.isEmpty()) return rating;
        for (RatetingRestourant ratetingRestourant : listRatetingRestourant) {

            rating += ratetingRestourant.getRatePoin();
        }
        return rating / listRatetingRestourant.size();
    }
}
