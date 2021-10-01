
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.services;

import com.hai.las.data.entity.BookingRequest;
import java.util.List;


import org.springframework.stereotype.Service;

/**
 *
 * @author hai
 */

@Service
public interface BookingRequestService {

    public List<BookingRequest> findAllBookingRequests();

    public BookingRequest findBookingRequestAndGetQuestion(Integer id);

    public BookingRequest findByBookingRequestId(Integer id);

    public long countBookingRequest();

    public BookingRequest createBookingRequest(BookingRequest bookingRequest);

    public BookingRequest updateBookingRequest(BookingRequest bookingRequest);

    public void deleteBookingRequests(List<Integer> ids);
}
