package com.example.demo.favtr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavTrService {
	
	@Autowired
	FavTrDao favTrDao;
	
	public void AddFavTr(String ez_tr_user_id,String ez_user_id) {
		System.out.println("FavTrService : AddFavTr");
		favTrDao.updateFavTr(ez_tr_user_id, ez_user_id);
	}

}
