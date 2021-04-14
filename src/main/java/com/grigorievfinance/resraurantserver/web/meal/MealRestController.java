package com.grigorievfinance.resraurantserver.web.meal;

import com.grigorievfinance.resraurantserver.model.Meal;
import com.grigorievfinance.resraurantserver.repository.MealRepository;
import com.grigorievfinance.resraurantserver.repository.UserRepository;
import com.grigorievfinance.resraurantserver.web.AuthUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static com.grigorievfinance.resraurantserver.util.ValidationUtil.*;

@RestController
@RequestMapping(value = MealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class MealRestController {
    static final String REST_URL = "/rest/profile/meals";

    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Meal> get(@AuthenticationPrincipal AuthUser authUser, @PathVariable int id) {
        log.info("get meal {} for user {}", id, authUser);
        return ResponseEntity.of(mealRepository.get(id, authUser.id()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal AuthUser authUser, @PathVariable int id) {
        log.info("delete {} for user {}", id, authUser);
        checkSingleModification(mealRepository.delete(id, authUser.id()), "Meal id=" + id + ", user id=" + authUser.id() + " missed");
    }

    @GetMapping
    public List<Meal> getAll(@AuthenticationPrincipal AuthUser authUser) {
        log.info("get all meals for user {}", authUser);
        return mealRepository.getAll(authUser.id());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@AuthenticationPrincipal AuthUser authUser, @Valid @RequestBody Meal meal, @PathVariable int id) {
        log.info("update {} for user {}", meal, authUser);
        assureIdConsistent(meal, id);
        checkNotFoundWithId(mealRepository.get(id, authUser.id()), "Meal id=" + id + " doesn't belong to user id=" + authUser.id());
        meal.setUser(userRepository.getOne(authUser.id()));
        mealRepository.save(meal);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createWithLocation(@AuthenticationPrincipal AuthUser authUser, @Valid @RequestBody Meal meal) {
        log.info("create meal {} for user {}", meal, authUser);
        checkNew(meal);
        meal.setUser(userRepository.getOne(authUser.id()));
        Meal created = mealRepository.save(meal);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
