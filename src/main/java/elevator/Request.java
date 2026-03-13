package elevator;

public class Request {
    private int floor;
    private RequestType requestType;

    public  Request(int floor, RequestType requestType) {
        this.floor = floor;
        this.requestType = requestType;
    }

    public int getFloor() {
        return floor;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        if (floor != request.floor) return false;
        return requestType == request.requestType;
    }

    @Override
    public String toString() {
        return "floor "  + floor + ", requestType " + requestType;
    }
}
