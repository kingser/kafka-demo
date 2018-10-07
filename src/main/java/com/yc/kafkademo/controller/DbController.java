package com.yc.kafkademo.controller;


import com.yc.kafkademo.dao.PeopleDao;
import com.yc.kafkademo.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * 描述:
 *
 * @author YC
 * @create 2018-10-07 16:03
 */


@RestController
@RequestMapping("/mydb")
public class DbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PeopleDao peopleDao;

    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from person limit 10 ";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    @RequestMapping("/user/{id}")
    public Map<String,Object> getUser(@PathVariable String id){
        Map<String,Object> map = null;

        List<Map<String, Object>> list = getDbType();

        for (Map<String, Object> dbmap : list) {

            Set<String> set = dbmap.keySet();

            for (String key : set) {
                if(key.equals("id")){
                    if(dbmap.get(key).equals(id)){
                        map = dbmap;
                    }
                }
            }
        }

        if(map==null)
            map = list.get(0);
        return map;
    }
   /* @RequestMapping("/save")
    public void savePeople(){
        String sql = "insert into person (name,age,nation,address) values (?,?,?,?)";
        for(int i=0;i<=100000;i++){
            jdbcTemplate.update(sql,"name"+i,i,"nation"+i,"address"+i);

        }

    }*/

    @RequestMapping("test")
    public Page<People> test(){
        return  peopleDao.findAll(new PageRequest(0,10));
    }
    @RequestMapping("save")
    public void save(){
        People people = new People();
        people.setName("张三");
        people.setAge(19);
        people.setAddress("太原");
        people.setNation("01");
        peopleDao.save(people);
    }
}

