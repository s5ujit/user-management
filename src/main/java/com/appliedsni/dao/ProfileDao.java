package com.appliedsni.dao;



import com.appliedsni.entity.Profile;



public interface ProfileDao extends BaseJpaDao {

    Profile findByProfileId(String pProfileId);

}
