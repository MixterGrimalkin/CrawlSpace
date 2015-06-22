package net.amarantha.crawlspace.scene;

public class EventLoop extends Event {

    private EventManager events;

    private double from;
    private double to;

    private boolean loopEnabled = true;

    private boolean loopActive = false;

    public EventLoop(EventManager events, double from, double to) {
        this.events = events;
        this.from = from;
        this.to = to;
        setValidityEnd(to);
    }

    public void breakLoop() {
        if ( loopActive ) {
            loopEnabled = false;
            events.jumpTo(to);
        }
    }

    @Override
    public void onTrigger() {
        loopActive = true;
        System.out.println("trigger loop");
        if ( loopEnabled ) {
            events.jumpTo(from);
        }
    }

    @Override
    protected void onDispose() {
        loopActive = false;
        loopEnabled = true;
    }

}
