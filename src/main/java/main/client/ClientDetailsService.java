package main.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsService implements UserDetailsService {
	@Autowired
	private ClientRepository clientRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Client> rs = this.clientRepo.findById(username);
		if(rs.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}
		return new ClientDetails(rs.get());
	}

}
