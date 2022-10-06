package com.zookeper.hoxtonjavazookeper;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZookeperRoutes {
  @Autowired
  private ZookeperRepository zookeperRepository;

  @GetMapping("/zookepers")
  public List<Zookeper> getZookepers() {
    return zookeperRepository.findAll();
  }

  @PostMapping("/zookepers")
  public Zookeper createZookeper(@RequestBody Zookeper zookeper) {
    Zookeper newZookeper = zookeperRepository.save(zookeper);
    return newZookeper;
  }
  @DeleteMapping("/zookepers/{id}")
  public String deleteZookeper(@PathVariable Integer id){
     zookeperRepository.deleteById(id);
     return "asd";
  }
  @PatchMapping("/zookepers/{id}")
  public Zookeper updateZookeper(@PathVariable Integer id, @RequestBody Zookeper zookeper){
    zookeper.id = id;
    return zookeperRepository.save(zookeper);
  }
}

interface ZookeperRepository extends JpaRepository<Zookeper, Integer> {
}