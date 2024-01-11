package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private TransferDao transferDao;

    public  TransferController (TransferDao transferDao){
        this.transferDao = transferDao;
    }

    public List<Transfer> getAllTransfers (){

        return null;
    }
}
