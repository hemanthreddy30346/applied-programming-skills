class ParkingSystem {
    
    // Array to store the available slots for big (index 0), medium (index 1), and small (index 2) cars.
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[] { big, medium, small };
    }
    
    public boolean addCar(int carType) {
        // carType is 1 for big, 2 for medium, and 3 for small.
        // We map carType to the corresponding array index (carType - 1).
        int index = carType - 1;
        
        if (slots[index] > 0) {
            slots[index]--; // Park the car by reducing the available slot count
            return true;
        }
        
        return false; // No available slot for this car type
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */