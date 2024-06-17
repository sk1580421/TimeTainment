package com.timetainment.timetainment.configuration;

import com.timetainment.timetainment.model.usermodel.Authorities;
import com.timetainment.timetainment.model.usermodel.Users;
import com.timetainment.timetainment.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TimeTainmentUserDetails implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<Users>  users = userRepository.findByEmail(username);
        if(users.isEmpty()){
            throw new UsernameNotFoundException("user not found"+username);
        }else{
            userName = users.getFirst().getUsername();
            password = users.getFirst().getPassword();
        }
        return new User(userName,password,getGrantedAuthorities(users.getFirst().getAuthorities()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authorities> authorities){
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for(Authorities authority : authorities){
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
}
