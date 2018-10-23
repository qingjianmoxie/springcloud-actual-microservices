package com.zzg.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zzg.springcloud.entities.Dept;
import com.zzg.springcloud.service.feign.DeptFeignClient;

import feign.hystrix.FallbackFactory;

@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptFeignClient>
{
	@Override
	public DeptFeignClient create(Throwable throwable)
	{
		return new DeptFeignClient() {
			@Override
			public Dept get(long id)
			{
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public List<Dept> list()
			{
				return null;
			}

			@Override
			public boolean add(Dept dept)
			{
				return false;
			}
		};
	}
}
