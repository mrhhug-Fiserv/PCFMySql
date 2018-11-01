package com.webreadllc.PCFMySql;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author michael
 */
@RestController("/api/")
public class MainController {
    @Autowired 
    private MemberRepository userRepository;

    @PutMapping("/api/add/{name}/{specialty}/{singer}")
    public void add (@PathVariable String name, @PathVariable String specialty, @PathVariable Boolean singer) {
	userRepository.save(new BandMember(name, specialty, singer));
    }
    
    @PutMapping("/api/addOrUpdate/{id}/{name}/{specialty}/{singer}")
    public void addOrUpdate (@PathVariable Integer id, @PathVariable String name, @PathVariable String specialty, @PathVariable Boolean singer) {
	userRepository.save(new BandMember(id, name, specialty, singer));
    }
    
    @PutMapping("/api/GodBlessTheGreatfulDead")
    public void addTheGreatfulDead () {
	userRepository.save(new BandMember("Tom Constanten", "Keyboards", false));
	userRepository.save(new BandMember("Jerry Garcia", "Guitar", true));
	userRepository.save(new BandMember("Donna Jean Godchaux", "Vocals", true));
	userRepository.save(new BandMember("Keith Godchaux", "Keyboards", false));
	userRepository.save(new BandMember("Mickey Hart", "Drums", false));
	userRepository.save(new BandMember("Bill Kreutzmann", "Drums", false));
	userRepository.save(new BandMember("Phil Lesh", "Bass guitar", true));
	userRepository.save(new BandMember("Ron \"Pigpen\" McKernan", "Keyboards", true));
	userRepository.save(new BandMember("Brent Mydland", "Keyboards", true));
	userRepository.save(new BandMember("Steve Parish", "Roadie", false));
	userRepository.save(new BandMember("Bob Weir", "Guitar", true));
	userRepository.save(new BandMember("Vince Welnick", "Keyboards", true));
    }

    @GetMapping("/api/get/{id}")
    public Optional<BandMember> get(@PathVariable Integer id) {
	return userRepository.findById(id);
    }
    
    @GetMapping("/api/getAll")
    public Iterable<BandMember> getAll() {
	return userRepository.findAll();
    }
    
    @DeleteMapping("/api/delete/{id}")
    public void delete(@PathVariable Integer id) {
	userRepository.delete(new BandMember(id));
    }
    
    @DeleteMapping("/api/deleteAll")
    public void deleteAll() {
	userRepository.deleteAll();
    }
}
