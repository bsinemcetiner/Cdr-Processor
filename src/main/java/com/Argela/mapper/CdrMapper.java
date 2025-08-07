package com.Argela.mapper;

import com.Argela.dataTransferObject.CdrRequest;
import com.Argela.entities.Cdr;
import org.springframework.stereotype.Component;

@Component
public class CdrMapper {
    public Cdr toEntity(CdrRequest request) {
        double costPerMinute = 0.10;
        double durationInMinutes = request.getConversationDuration() / 60.0;
        double callCost = durationInMinutes * costPerMinute;

        return Cdr.builder()
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .imsi(request.getImsi())
                .imei(request.getImei())
                .cellId(request.getCellId())
                .lacId(request.getLacId())
                .aNumber(request.getAnumber())
                .bNumber(request.getBnumber())
                .setupDuration(request.getSetupDuration())
                .conversationDuration(request.getConversationDuration())
                .direction(request.getDirection())
                .result(request.getResult())
                .callCost(callCost)
                .build();
    }
}