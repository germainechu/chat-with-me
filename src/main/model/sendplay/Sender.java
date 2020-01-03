package model.sendplay;

import model.exceptions.SenderTooManyException;

import java.util.List;

public interface Sender {

    String getName();

    void setName(String name);

    boolean checkContains(List<Sender> bwList, Sender bw) throws SenderTooManyException;



}
