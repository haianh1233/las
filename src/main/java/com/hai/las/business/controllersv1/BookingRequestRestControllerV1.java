/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllersv1;

import com.hai.las.business.controllers.BookingRequestOperations;
import com.hai.las.business.services.BookingRequestService;
import com.hai.las.data.entity.BookingRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wifil
 */
@RestController
@RequestMapping("/api/v1/booking-requests")
public class BookingRequestRestControllerV1 implements BookingRequestOperations {

    private final BookingRequestService service;

    @Autowired
    public BookingRequestRestControllerV1(BookingRequestService service) {
        this.service = service;
    }

    @Override
    public List<BookingRequest> getAllBookingRequests() {
        return service.findAllBookingRequests();
    }

    @Override
    public BookingRequest getBookingRequestById(@PathVariable Integer id) {
        return service.findByBookingRequestId(id);
    }

    @Override
    public BookingRequest getBookingRequestWithQuestionsById(@PathVariable Integer id) {
        return service.findBookingRequestAndGetQuestion(id);
    }
    
    @Override
    public BookingRequest createBookingRequest(@RequestBody BookingRequest bookingRequest) {
        return service.createBookingRequest(bookingRequest);
    }

    @Override
    public BookingRequest updateBookingRequest(@RequestBody BookingRequest BookingRequest) {
        return service.updateBookingRequest(BookingRequest);
    }

    @Override
    public void deleteBookingRequests(@RequestBody List<Integer> ids) {
        service.deleteBookingRequests(ids);
    }
}
