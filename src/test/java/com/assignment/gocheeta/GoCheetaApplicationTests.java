package com.assignment.gocheeta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.assignment.gocheeta.entity.User;
import com.assignment.gocheeta.repository.UserRepository;
import com.assignment.gocheeta.services.UserService;

@SpringBootTest
class GoCheetaApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	// @Test
	// void contextLoads() {
	// System.out.print("Hello friends!")
	// }
	@Test
	public void getUserTest() {
		when(userRepository.findAll())
				.thenReturn(Stream
						.of(new User(1, "name", "name@gmail.com", "password", "00000"),
								new User(2, "Heshan", "kalana@gmail.com", "password123", "0000"))
						.collect(Collectors.toList()));
		assertEquals(2, userService.getAllUsers().size());
	}

	// @Test
	// public void getUserById(){
	// int id = 1;
	// when(userRepository.findById(id)).thenReturn(Stream.of(new User(1,
	// "name","name@gmail.com", "password")).collect(Collectors.toList())
	// }

	@Test
	public void saveUserTest() {
		User user = new User(0, "Name", "name@gmail.com", "password", "0000");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(null, userService.createUser(user));
	}

	// @Test
	// public void deleteUser() {
	// Long id = 0;
	// userService.deleteUser(id);
	// verify(userRepository, )

	// }

	@Test
	public void editUser() {
		User user = new User(0, "Name", "name@gmail.com", "password", "0000");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(null, userService.updateUser(user.getId(), user));
	}

}
