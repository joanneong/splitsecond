package com.splitsecond;

import com.splitsecond.data.Trip;
import com.splitsecond.data.TripRepository;
import com.splitsecond.data.Tripper;
import com.splitsecond.data.TripperRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SplitSecondApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SplitSecondApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SplitSecondApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TripRepository tripRepository,
								  TripperRepository tripperRepository) {
		return args -> {
			Trip trip = new Trip("Aus trip", OffsetDateTime.now(), OffsetDateTime.now().plusDays(5));

			LOGGER.info("==========================");
			LOGGER.info("Saving trip");
			tripRepository.save(trip);
			LOGGER.info(trip.toString());

			LOGGER.info("==========================");
			LOGGER.info("Getting ALL trips");
			tripRepository.findAll().forEach(t -> LOGGER.info(t.toString()));

			LOGGER.info("==========================");
			LOGGER.info("Getting trip");
			LOGGER.info(trip.getId().toString());
			LOGGER.info(String.valueOf(tripRepository.existsById(trip.getId())));
			tripRepository.findById(trip.getId()).ifPresent(v -> LOGGER.info(v.toString()));

			LOGGER.info("==========================");
			LOGGER.info("Saving trippers");
			tripperRepository.save(new Tripper(trip.getId(), "A"));
			tripperRepository.save(new Tripper(trip.getId(), "B"));

			LOGGER.info("==========================");
			LOGGER.info("Getting ALL trippers");
			tripperRepository.findAll().forEach(t -> LOGGER.info(t.toString()));

			LOGGER.info("==========================");
			LOGGER.info("Getting trippers");
			List<Tripper> trippers = tripperRepository.findByTripId(trip.getId());
			for (Tripper t : trippers) {
				LOGGER.info(t.toString());
			}

			LOGGER.info("==========================");
			LOGGER.info("Saving dup");
			tripperRepository.save(new Tripper(UUID.randomUUID(), "C"));
		};
	}

}
