package com.ikonsoft.services;

import java.util.List;
import java.util.Map;

public interface IBudgetService {
	 
  
public	long getBudget(List<String> channels,Map<String, Long> customerNoPerChannel,Map<String, Long> valuePerChannel);

}
