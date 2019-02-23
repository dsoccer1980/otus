package ru.dsoccer1980.service;

public class UserAnswerServiceImpl implements UserAnswerService {

    private final IOService ioService;

    public UserAnswerServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public String readAnswer(int id) {
        return ioService.read();
    }


}
