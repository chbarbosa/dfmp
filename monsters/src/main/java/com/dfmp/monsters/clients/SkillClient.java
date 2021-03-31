package com.dfmp.monsters.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dfmp.monsters.SkillVO;

@FeignClient(name = "skills", url = "http://localhost:8080")
public interface SkillClient {

    @RequestMapping(method = RequestMethod.GET, value = "/skill/{skillId}", consumes = "application/json")
    SkillVO getSkill(@PathVariable("skillId") Long skillId);

}
