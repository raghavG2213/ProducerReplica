package com.tcs.service.controller

import com.tcs.service.model.Dummy
import com.tcs.service.model.ServiceResponse
import com.tcs.service.service.Producer
//import com.tcs.service.service.Producer
import javafx.application.Application
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class Controller
(private val producer: Producer)
{


    @RequestMapping("/post", method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody dummy: Dummy): ResponseEntity<ServiceResponse> {

        println("Dummy Data")
        println(dummy.shipmentId)

        producer.create(dummy)

        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", "Data Posted"))


    }
//
//    @RequestMapping("/ecmr",method = [RequestMethod.GET])
//    fun getAll(): ResponseEntity<ServiceResponse> {
//       val result = ecmrRepo.findAll()
//
//        return ResponseEntity.ok(ServiceResponse("200",
//                "SUCCESS", result))
//    }
//
//    @RequestMapping("/ecmr/{id}",method = [RequestMethod.GET])
//    fun getECMRData(@PathVariable id: String) {
//
//        val result = Utility.convert(URLPath.BASE_URI + id, ASN())
//        println(result)
//
//    }
//
//        @RequestMapping("/getdata/{shipId}",method = [RequestMethod.GET])
//    fun getByMessageNo(@PathVariable shipId: String): ResponseEntity<ServiceResponse> {
//
//        val result = customRepo.findAllByQueryParams(shipId)
//        return ResponseEntity.ok(ServiceResponse("200",
//                "SUCCESS", result))
//
//    }
//
//    @RequestMapping(value = [POST_PUT_DELETE_URI], method = [RequestMethod.PUT], produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun put(@RequestBody model: ECMR): ResponseEntity<ServiceResponse> {
//        println("it came in put")
//        ecmrRepo.save(model)
//        return ResponseEntity.ok(ServiceResponse("200",
//                "SUCCESS", "Data Successfully Updated"))
//    }
}