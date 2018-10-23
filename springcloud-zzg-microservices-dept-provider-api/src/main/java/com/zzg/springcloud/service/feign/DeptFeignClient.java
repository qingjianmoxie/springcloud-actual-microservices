package com.zzg.springcloud.service.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzg.springcloud.entities.Dept;
import com.zzg.springcloud.service.DeptClientServiceFallbackFactory;


/**
 * 
 * @Description: 修改microservicecloud-api工程，根据已经有的DeptClientService接口

新建

一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author zzg
 */
//@FeignClient(value = "SPRINGCLOUD-ZZG-MICROSOFTSERVICES-PROVIDER-DEPT")
@FeignClient(value = "SPRINGCLOUD-ZZG-MICROSERVICES",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptFeignClient
{
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
}
