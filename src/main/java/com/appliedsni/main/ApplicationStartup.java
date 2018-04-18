package com.appliedsni.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.appliedsni.dao.UserDao;
import com.appliedsni.entity.AccessRight;
import com.appliedsni.utility.AsscessRightUtility;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {

  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
	@Autowired
	UserDao userDao;
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
 
	  AsscessRightUtility.setAcessRightList(userDao.getAccessRight());
  }
 
}