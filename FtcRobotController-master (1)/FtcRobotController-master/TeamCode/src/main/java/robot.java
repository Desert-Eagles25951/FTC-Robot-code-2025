import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive;
import org.firstinspires.ftc.teamcode.powertrain;


@TeleOp(name="drive", group="drive.v2")
public class robot extends CommandOpMode
{

    private MotorEx right,left;
    private final  double wheel_diameter = 4;

    private  powertrain drivetrain;
    private final GamepadEx ps4 = new GamepadEx(gamepad1);
    private drive drivecomand;


    @Override
    public void initialize() {
      drivetrain = new powertrain(hardwareMap, "left","right",wheel_diameter);

         drivecomand = new drive(drivetrain
                , ps4::getLeftY
                , ps4::getRightX
        );

      register(drivetrain);
      drivetrain.setDefaultCommand(drivecomand);


    }


}




