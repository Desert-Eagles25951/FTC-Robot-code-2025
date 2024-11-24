import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.motors.RevRobotics20HdHexMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive;
import org.firstinspires.ftc.teamcode.powertrain;


@TeleOp(name="drive", group="drive.v2")
public class robot extends CommandOpMode
{

    private MotorEx right,left;
    private double wheel_diameter = 4;

    private powertrain drivetrain = new powertrain(right,left,wheel_diameter);
    private GamepadEx ps4 = new GamepadEx(gamepad1);
    private drive drivecomand;


    @Override
    public void initialize() {
      right = new MotorEx(hardwareMap, "right");
      left = new MotorEx(hardwareMap, "left");

      drivecomand = new drive(drivetrain, ()-> ps4.getLeftY(), ()-> ps4.getRightX());

      drivetrain.setDefaultCommand(drivecomand);


    }


}




