package com.esame.progetto.util.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.esame.progetto.model.InfoDayOne;
@Service
public interface DayOneService {
	public List<InfoDayOne> getDayOneData(String country) throws MalformedURLException, IOException;



}
