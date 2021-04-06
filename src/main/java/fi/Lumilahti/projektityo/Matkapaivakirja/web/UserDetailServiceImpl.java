package fi.Lumilahti.projektityo.Matkapaivakirja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.User;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository urepository) {
		this.repository = urepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
}
