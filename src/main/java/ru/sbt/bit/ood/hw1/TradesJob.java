package ru.sbt.bit.ood.hw1;

import java.util.Collection;

public class TradesJob {

    final private DummyParser dummyParser;
    final private DummyDownloader dummyDownloader;
    final private TradesDAO tradesDAO;

    public TradesJob(TradesDAO tradesDAO, DummyDownloader dummyDownloader, DummyParser dummyParser) {
        this.tradesDAO = tradesDAO;
        this.dummyDownloader = dummyDownloader;
        this.dummyParser = dummyParser;
    }

    private void updateTrades(Collection<Trade> trades) {
        tradesDAO.deleteAll();
        for (Trade trade : trades) {
            tradesDAO.save(trade);
        }
    }

    public void run() {
        String filename = dummyDownloader.download();
        Collection<Trade> tradeRecords = dummyParser.parse(filename);
        updateTrades(tradeRecords);
    }

}
