package com.appliedsni.dao;


import com.appliedsni.constants.Role;
import com.appliedsni.entity.Profile;



public interface ProfileDao extends BaseJpaDao {

    Profile findByProfileId(Role pProfileId);

}
