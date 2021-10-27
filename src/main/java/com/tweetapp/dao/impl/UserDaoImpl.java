package com.tweetapp.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.tweetapp.bean.JwtRequestBean;
import com.tweetapp.bean.user.UserInfoBean;
import com.tweetapp.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	
    @Override
    public UserInfoBean findByLoginId(String loginId) {
    	System.out.println("LoginId::"+loginId);
        return dynamoDBMapper.load(UserInfoBean.class, loginId);
    }
    
	@Override
	public Optional<UserInfoBean> findByEmailId(String emailId) {
		UserInfoBean user = dynamoDBMapper.load(UserInfoBean.class,emailId);
		if (user != null)
			return Optional.of(user);
		return Optional.empty();
	}

	@Override
	public Optional<UserInfoBean> findByContactNumber(String contactNumber) {
		UserInfoBean user = dynamoDBMapper.load(UserInfoBean.class,contactNumber);
		if (user != null)
			return Optional.of(user);
		return Optional.empty();
	}

	@Override
	public void saveUser(UserInfoBean userInfoBean) {
		try {
		dynamoDBMapper.save(userInfoBean);
		} catch (AmazonClientException e) {
			System.out.println("Exception::"+e.getMessage());
		}
		
	}

//	@Override
//	public void updatePassword(JwtRequestBean userBean) {
//		Update update = new Update();
//		update.set("password", userBean.getPassword());
//		dynamoDBMapper..updateFirst(Query.query(Criteria.where("loginId").is(userBean.getLoginId())), update,
//				UserInfoBean.class);
//	}

}
