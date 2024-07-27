import entities.client.Client;
import entities.vehicle.Vehicle;
import entities.spot.ParkinSpotImp;
import entities.spot.ParkingSpot;

import imp.ParkingImp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;


import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

public final class ParkingSystem extends ParkingImp {

    private final @NotNull Map<@NotNull Integer, @NotNull Client> clients;
    private final @NotNull Map<@NotNull String, @NotNull Vehicle> vehicles;
    private final @NotNull Map<@NotNull Integer, @NotNull ParkingSpot> spots;

    public ParkingSystem(int totalSpots) {
        this.clients = new HashMap<>();
        this.vehicles = new HashMap<>();
        this.spots = new HashMap<>();
        for (int i = 1; i < totalSpots; i++) {
            spots.put(i, new ParkinSpotImp(i));
        }
    }

    @Override
    public boolean isAvaliable(@Range(from = 0, to = Long.MAX_VALUE) int spotId) {
        try {
            checkers(spotId);
            if (spotId == 0) {
                System.out.println("Id invalid");
                return false;
            }
            return spots.get(spotId).isEmpty();
        } catch (IllegalArgumentException e) {
            System.out.println("Id invalid");
            return false;
        }
    }

    @Override
    public void reserveSpot(@Range(from = 0, to = Long.MAX_VALUE) int spotId, @NotNull Client client) {
        try {
            checkers(spotId);
            if (!isAvaliable(spots.get(spotId))) {
                System.out.println("This spot is in use");
            } else {
                spots.get(spotId).ocuppy(client);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Id invalid");
        }
    }

    @Override
    public void releaseSpot(@Range(from = 0, to = Long.MAX_VALUE) int spotID) {
        try {
            checkers(spotID);
            spots.get(spotID).vacate();
        } catch (IllegalArgumentException e) {
            System.out.println("Id invalid");
        }
    }

    @Override
    public @Nullable ParkingSpot getSpot(@NotNull Vehicle vehicle) {
        return spots.values().stream()
                .filter(spot -> spot.getVehicle() == vehicle)
                .findFirst()
                .orElse(null);
    }

    @Override
    public @Nullable ParkingSpot getSpot(@NotNull Client client) {
        return spots.values().stream()
                .filter(spot -> spot.getClient() == client)
                .findFirst()
                .orElse(null);
    }


    @Override
    public @NotNull Vehicle getVehicle(@NotNull String plate) {
        return vehicles.get(plate);
    }

    @Override
    public @Nullable Vehicle getVehicle(@Range(from = 0, to = Long.MAX_VALUE) int spotId) {
        try {
            checkers(spotId);
            return spots.get(spotId).getVehicle();
        } catch (IllegalArgumentException e) {
            System.out.println("id invalid");
            return null;
        }
    }

    @Override
    public @Nullable Client getClient(@Range(from = 0, to = Long.MAX_VALUE) int spotId) {
        return spots.get(spotId).getClient();
    }

    @Override
    public @Nullable Client getClient(@NotNull String cpf) {
        return clients.values().stream()
                .filter(client -> client.getCpf().equalsIgnoreCase(cpf))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void checkers(@Range(from = 0, to = Long.MAX_VALUE) int spotId) {
        if (spotId > spots.size() || spotId == 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected boolean isAvaliable(@NotNull ParkingSpot spot) {
        return spot.getStatus() == ParkingSpot.Status.AVALIABLE;
    }

    @Override
    public @NotNull ParkingSpot getSpot(int id) {
        try {
            checkers(id);
            return spots.get(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Id invalid");
        }
    }

    @Override
    public @Nullable OffsetDateTime getTime(@Range(from = 0, to = Long.MAX_VALUE) int spotId) {
        return spots.get(spotId).getInitialHour();
    }

    @Override
    public @NotNull List<@NotNull Integer> getAvaliableSpots() {
        return spots.values().stream()
                .filter(spot -> spot.getStatus() == ParkingSpot.Status.AVALIABLE)
                .map(ParkingSpot::getId)
                .collect(Collectors.toList());
    }

    @Override
    public @NotNull List<@NotNull Integer> getOccupedSpot() {
        return spots.values().stream()
                .filter(spot -> spot.getStatus() == ParkingSpot.Status.OCCUPIED)
                .map(ParkingSpot::getId)
                .collect(Collectors.toList());
    }

    @Override
    public void registerClient(@NotNull Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public void registerVehicle(@NotNull Vehicle vehicle) {
        vehicles.put(vehicle.getPlate(), vehicle);
    }

}
