package org.matrix.androidsdk.data;

import org.matrix.androidsdk.rest.model.Event;
import org.matrix.androidsdk.rest.model.User;

import java.util.Collection;

/**
 * An interface for storing and retrieving Matrix objects.
 */
public interface IMXStore {
    public Collection<Room> getRooms();
    public Room getRoom(String roomId);
    public User getUser(String userId);
    public void storeUser(User user);
    public void storeRoom(Room room);

    /**
     * Store this non-state room event so it can be retrieved later.
     * @param event The event to be stored.
     */
    public void storeRoomEvent(Event event);

    /**
     * Retrieve all non-state room events for this room.
     * @param roomId The room ID
     * @param limit A hint for the max number of latest events to return. Does not need to be
     *              honoured.
     * @return A collection of events.
     */
    public Collection<Event> getRoomEvents(String roomId, int limit);

    /**
     * Update room state.
     * @param room The room to update.
     * @param stateEventType The state event type which was updated. Can be null to clobber the room.
     */
    public void updateRoomState(Room room, String stateEventType);
}