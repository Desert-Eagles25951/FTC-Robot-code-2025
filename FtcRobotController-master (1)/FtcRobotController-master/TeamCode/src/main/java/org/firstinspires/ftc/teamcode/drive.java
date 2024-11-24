package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.function.DoubleSupplier;

public class drive extends CommandBase {

    // The subsystem the command runs on
    private final powertrain Cdrive;
    DoubleSupplier x;
    DoubleSupplier z;


    public drive(powertrain subsystem,DoubleSupplier speed, DoubleSupplier turn) {
        Cdrive = subsystem;
        x = speed;
        z = turn;
        addRequirements(Cdrive);
    }

    @Override
    public void execute() {
        Cdrive.arcade(
                x.getAsDouble(),
                z.getAsDouble()
        );
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}