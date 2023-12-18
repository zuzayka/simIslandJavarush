package dialogs;

import lombok.Getter;
import simIsland.immutableParameters.IslandProperties;
import java.util.Scanner;

@Getter
public class SimulationDialog {
    private int scannerWidth;
    private int scannerHeight;
    private int scannerCycles;
    private int scannerDensity;

    public SimulationDialog() {
        try (Scanner scanner = new Scanner(System.in)) {
            String island = """
                                             
                                             
                                             000000    000000         00         000000   00      00        00     000000    00             00        00     00   000000
                                            0000000    0000000       0000        000000    00    00         00    0000000    00            0000       000    00   0000000
                                            00         00   00      00  00          00      00  00          00    00         00           00  00      0000   00   00   00
                                            00         000000      00    00        00        0000           00     00000     00          00    00     00 00  00   00   00
                                            00         00000      0000000000      00          00            00         00    00         0000000000    00 00  00   00   00
                                            0000000    00  00    00        00    000000       00            00    0000000    0000000   00        00   00   0000   0000000
                                             000000    00   00  00          00   000000       00            00    000000     0000000  00          00  00    000   000000
                                            
                    """;
            System.out.println(island);
            System.out.print("Start simulation with default settings? 1 - yes, 0 - no: ");
            if (scanner.nextInt() == 1) {
                scannerWidth = IslandProperties.ISLAND_WIDTH_CONST;
                scannerHeight = IslandProperties.ISLAND_HEIGHT_CONST;
                scannerCycles = IslandProperties.ISLAND_CYCLES_CONST;
                scannerDensity = IslandProperties.DENSITY_CONST;
            } else {
                System.out.print("Enter island width: ");
                scannerWidth = scanner.nextInt();
                setWidth();
                System.out.print("Enter island height: ");
                scannerHeight = scanner.nextInt();
                setHeight();
                System.out.print("Enter island simulation cycles number: ");
                scannerCycles = scanner.nextInt();
                setCycles();
                System.out.print("Enter island simulation entities number as a percentage of the maximum entities value: ");
                scannerDensity = scanner.nextInt();
                setDensity();
            }
            System.out.println("island width: " + scannerWidth + "\nisland height: " + scannerHeight + "\ncycles simulation number: " + scannerCycles + "\nsimulation entities number as a percentage of the maximum entities: " + scannerDensity);
            IslandProperties.ISLAND_WIDTH = scannerWidth;
            IslandProperties.ISLAND_HEIGHT = scannerHeight;
            IslandProperties.ISLAND_CYCLES = scannerCycles;
            IslandProperties.DENSITY = scannerDensity;

        }


    }

    public void setWidth() {
        if ((scannerWidth < 2) || (scannerWidth > 100)) {
            scannerWidth = IslandProperties.ISLAND_WIDTH_CONST;
        }
    }

    public void setHeight() {
        if ((scannerHeight < 2) || (scannerHeight > 100)) {
            scannerHeight = IslandProperties.ISLAND_HEIGHT_CONST;
        }
    }

    public void setCycles() {
        if ((scannerCycles < 1) || (scannerCycles > 100)) {
            scannerCycles = IslandProperties.ISLAND_CYCLES_CONST;
        }
    }

    public void setDensity() {
        if ((scannerDensity < 1) || (scannerDensity > 100)) {
            scannerDensity = IslandProperties.DENSITY_CONST;
        }
    }

    public static void main(String[] args) {
        SimulationDialog sd = new SimulationDialog();
    }
}
