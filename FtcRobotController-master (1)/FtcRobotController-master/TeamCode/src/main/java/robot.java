import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.motors.RevRobotics20HdHexMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.drive;
import org.firstinspires.ftc.teamcode.powertrain;

import java.util.function.DoubleSupplier;


@TeleOp(name="drive", group="drive.v2")
public class robot extends OpMode
{
   private final powertrain drivetrain = new powertrain();
    DoubleSupplier speed, turn;
    private final drive drive = new drive(drivetrain ,  speed,  turn);
    public GamepadEx ps4 = new GamepadEx(gamepad1);


    @Override
    public void init() {

    }


    @Override
    public void loop() {
     drivetrain.setDefaultCommand(new drive(
             drivetrain,
             ()-> ps4.getLeftY(),
             ()-> ps4.getRightX()
     ));

    }

}




