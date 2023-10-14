package com.zeloff.osahaeat.service;

import com.zeloff.osahaeat.entity.Restourant;
import com.zeloff.osahaeat.repository.RestaurantRepository;
import com.zeloff.osahaeat.service.imp.FilesStorageServiceImp;
import com.zeloff.osahaeat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    FilesStorageServiceImp filesStorageServiceImp;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public boolean insertRestaurant(MultipartFile file,
                                    String title,
                                    String sub_title,
                                    String description,
                                    boolean is_free,
                                    String address,
                                    String open_date) {
        boolean isSuccess = false;
        try {
            boolean isSuccessSaveFile = filesStorageServiceImp.save(file);
            if (isSuccessSaveFile) {
                Restourant restourant = new Restourant();
                restourant.setImage(file.getOriginalFilename());
                restourant.setTitle(title);
                restourant.setSubTitle(sub_title);
                restourant.setDescription(description);
                restourant.setFree(true);
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
}
