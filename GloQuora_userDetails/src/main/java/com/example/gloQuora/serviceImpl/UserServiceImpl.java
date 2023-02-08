package com.example.gloQuora.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gloQuora.dto.AddressDto;
import com.example.gloQuora.dto.CompanyDto;
import com.example.gloQuora.dto.GeoDto;
import com.example.gloQuora.dto.ResponseDto;
import com.example.gloQuora.dto.UserDto;
import com.example.gloQuora.model.Address;
import com.example.gloQuora.model.Company;
import com.example.gloQuora.model.Geo;
import com.example.gloQuora.model.UserDetails;
import com.example.gloQuora.repository.AddressRepo;
import com.example.gloQuora.repository.CompanyRepo;
import com.example.gloQuora.repository.GeoRepo;
import com.example.gloQuora.repository.UserRepo;
import com.example.gloQuora.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userDetailsRepository;

	@Autowired
	CompanyRepo companyRepository;

	@Autowired
	GeoRepo geoRepository;

	@Autowired
	AddressRepo addressRepository;

	@Override
	public Object addUser(UserDto userDto) {
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail(userDto.getEmail());
		userDetails.setName(userDto.getName());
		userDetails.setPhone(userDto.getPhone());
		userDetails.setUserName(userDto.getUserName());
		UserDetails savedUserDetails = userDetailsRepository.save(userDetails);
		Address address = new Address();
		address.setCity(userDto.getAddress().getCity());
		address.setStreet(userDto.getAddress().getStreet());
		address.setUserid(savedUserDetails);
		Address savedAddress = addressRepository.save(address);
		Geo geo = new Geo();
		geo.setLatitude(userDto.getAddress().getGeo().getLat());
		geo.setLongitude(userDto.getAddress().getGeo().getLongitude());
		geo.setUserId(savedUserDetails);
		Geo savedGeo = geoRepository.save(geo);
		userDetails.setAddress(address);
		userDetails.setGeo(geo);
		Company company = new Company();
		company.setLocation(userDto.getCompany().getName());
		company.setName(userDto.getCompany().getLocation());
		company.setUserId(savedUserDetails);
		Company savedCompany = companyRepository.save(company);
		userDetails.setAddress(savedAddress);
		userDetails.setGeo(savedGeo);
		userDetails.setCompany(savedCompany);
		return new ResponseDto<Object>("UserDetails saved Successfully", "1");
	}

	@Override
	public Object deleteUser(Long userId) {
		Optional<UserDetails> deleteDetails = userDetailsRepository.findById(userId);
		UserDetails deleteuserDetails = deleteDetails.get();
		companyRepository.deleteById(deleteuserDetails.getCompany().getCompanyId());
		geoRepository.deleteById(deleteuserDetails.getGeo().getGeoId());
		addressRepository.deleteById(deleteuserDetails.getAddress().getAddressId());
		userDetailsRepository.deleteById(deleteuserDetails.getUserId());
		return new ResponseDto<Object>("UserDetails Deleted succesfully", "1");
	}

	@Override
	public Object getAllUserDetails() {
		List<UserDetails> userDetailsFromRepo = userDetailsRepository.findAll();
		List<UserDto> responseDataList = new ArrayList<>();
		for (UserDetails userDetails : userDetailsFromRepo) {
			UserDto userDetailsDto = new UserDto();
			userDetailsDto.setUserId(userDetails.getUserId());
			userDetailsDto.setEmail(userDetails.getEmail());
			userDetailsDto.setName(userDetails.getName());
			userDetailsDto.setPhone(userDetails.getPhone());
			userDetailsDto.setUserName(userDetails.getUserName());
			AddressDto addressDto = new AddressDto();
			if (userDetails.getAddress() != null) {
				addressDto.setAddressId(userDetails.getAddress().getAddressId());
				addressDto.setCity(userDetails.getAddress().getCity());
				addressDto.setStreet(userDetails.getAddress().getStreet());
			}
			GeoDto geoDto = new GeoDto();
			if (userDetails.getGeo() != null) {
				geoDto.setGeoId(userDetails.getGeo().getGeoId());
				geoDto.setLat(userDetails.getGeo().getLatitude());
				geoDto.setLongitude(userDetails.getGeo().getLongitude());
			}
			addressDto.setGeo(geoDto);
			userDetailsDto.setAddress(addressDto);
			CompanyDto companyDto = new CompanyDto();
			if (userDetails.getCompany() != null) {
				companyDto.setCompanyId(userDetails.getCompany().getCompanyId());
				companyDto.setLocation(userDetails.getCompany().getName());
				companyDto.setName(userDetails.getCompany().getLocation());
			}
			userDetailsDto.setCompany(companyDto);
			responseDataList.add(userDetailsDto);
		}
		return new ResponseDto<Object>("UserDetails Fetched Successfully", "1", responseDataList);
	}

	@Override
	public Object getSpecificUserDetails(Long userId) {
		Optional<UserDetails> userDetailsFromRepo = userDetailsRepository.findById(userId);
		UserDto userDetailsDto = new UserDto();
		UserDetails userDetails1 = userDetailsFromRepo.get();
		userDetailsDto.setUserId(userDetails1.getUserId());
		userDetailsDto.setEmail(userDetails1.getEmail());
		userDetailsDto.setName(userDetails1.getName());
		userDetailsDto.setPhone(userDetails1.getPhone());
		userDetailsDto.setUserName(userDetails1.getUserName());
		AddressDto addressDto = new AddressDto();
		if (userDetails1.getAddress() != null) {
			addressDto.setAddressId(userDetails1.getAddress().getAddressId());
			addressDto.setCity(userDetails1.getAddress().getCity());
			addressDto.setStreet(userDetails1.getAddress().getStreet());
		}
		GeoDto geoDto = new GeoDto();
		if (userDetails1.getGeo() != null) {
			geoDto.setGeoId(userDetails1.getGeo().getGeoId());
			geoDto.setLat(userDetails1.getGeo().getLatitude());
			geoDto.setLongitude(userDetails1.getGeo().getLongitude());
		}
		addressDto.setGeo(geoDto);
		userDetailsDto.setAddress(addressDto);
		CompanyDto companyDto = new CompanyDto();
		if (userDetails1.getCompany() != null) {
			companyDto.setCompanyId(userDetails1.getCompany().getCompanyId());
			companyDto.setLocation(userDetails1.getCompany().getName());
			companyDto.setName(userDetails1.getCompany().getLocation());
		}
		userDetailsDto.setCompany(companyDto);
		return new ResponseDto<Object>("UserDetails Fetched Successfully", "1", userDetailsDto);
	}

	@Override
	public Object updateUser(UserDto userDetailsDto) {
		Optional<UserDetails> userDetails1 = userDetailsRepository.findById(userDetailsDto.getUserId());
		UserDetails userDetails = userDetails1.get();
		userDetails.setUserId(userDetailsDto.getUserId());
		userDetails.setEmail(userDetailsDto.getEmail());
		userDetails.setName(userDetailsDto.getName());
		userDetails.setPhone(userDetailsDto.getPhone());
		userDetails.setUserName(userDetailsDto.getUserName());
		UserDetails savedUserDetails = userDetailsRepository.save(userDetails);
		Address address = new Address();
		address.setAddressId(userDetailsDto.getAddress().getAddressId());
		address.setCity(userDetailsDto.getAddress().getCity());
		address.setStreet(userDetailsDto.getAddress().getStreet());
		address.setUserid(savedUserDetails);
		Address savedAddress = addressRepository.save(address);
		Geo geo = new Geo();
		geo.setGeoId(userDetailsDto.getAddress().getGeo().getGeoId());
		geo.setLatitude(userDetailsDto.getAddress().getGeo().getLat());
		geo.setLongitude(userDetailsDto.getAddress().getGeo().getLongitude());
		geo.setUserId(savedUserDetails);
		Geo savedGeo = geoRepository.save(geo);
		userDetails.setAddress(address);
		userDetails.setGeo(geo);
		Company company = new Company();
		company.setCompanyId(userDetailsDto.getCompany().getCompanyId());
		company.setLocation(userDetailsDto.getCompany().getName());
		company.setName(userDetailsDto.getCompany().getLocation());
		company.setUserId(savedUserDetails);
		Company savedCompany = companyRepository.save(company);
		userDetails.setAddress(savedAddress);
		userDetails.setGeo(savedGeo);
		userDetails.setCompany(savedCompany);
		return new ResponseDto<Object>("UserDetails Updated", "1");
	}

}
