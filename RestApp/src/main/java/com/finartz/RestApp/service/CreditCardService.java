package com.finartz.RestApp.service;

import com.finartz.RestApp.model.CreditCard;
import com.finartz.RestApp.repository.CreditCardRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    private final CreditCardRepository creditcardRepository;

    public CreditCardService(CreditCardRepository creditcardRepository) {
        this.creditcardRepository = creditcardRepository;
    }

    public List<CreditCard> findAll(){
        return creditcardRepository.findAll();
    }

    public CreditCard findById(Long id) {
        return creditcardRepository.getById(id);
    }

    public CreditCard create(CreditCard creditCard) {
        return creditcardRepository.save(creditCard);
    }

    public CreditCard update(CreditCard creditCard){
        CreditCard update = creditcardRepository.getById((long) creditCard.getId());
        if(update != null) {
            creditcardRepository.save(creditCard);
            return update;
        }
        return creditCard;
    }

    public void deleteById(Long id){
        creditcardRepository.deleteById(id);
    }
}
