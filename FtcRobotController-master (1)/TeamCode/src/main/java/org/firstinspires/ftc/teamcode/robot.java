package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;


import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;


import java.util.Collections;
import java.util.Set;
import java.util.Timer;


@TeleOp(name = " tlaxcala")
public class robot extends OpMode
{
  public GamepadEx ps4;
  private powertrain drivetrain;
  private  elevator elevator;
  private  arm_Gripper Arm;

  //rutines
  private RutineTakePIece Takepiece;

  //Botons
    Button A,B,Y,X;



        @Override
        public void init() {
            //subsystem and control
            drivetrain = new powertrain(hardwareMap);
            ps4 = new GamepadEx(gamepad1);
            elevator = new elevator(hardwareMap);
            Arm = new arm_Gripper(hardwareMap);

            //Botons

            A = new GamepadButton(ps4 ,GamepadKeys.Button.A);
            B = new GamepadButton(ps4, GamepadKeys.Button.B);
            Y = new GamepadButton(ps4, GamepadKeys.Button.Y);
            X = new GamepadButton(ps4, GamepadKeys.Button.X);

            //rutines
            Takepiece = new RutineTakePIece(Arm);
        }



        @Override
        public void init_loop() {


        }



        @Override
        public void start() {
            Arm.armOffset();

        }

        @Override
        public void loop() {

            ps4.readButtons();
            drivetrain.inputcontrol(ps4);
            drivetrain.arcade();
            elevator.loop();


            //controls

            //climber
            A.whenPressed( new InstantCommand(()->
            {
                elevator.climber();

            })).whenReleased(new InstantCommand(()->
            {
                elevator.offsetPOs();
            }));

            B.whenPressed(new InstantCommand(()->{
                Arm.TakePiece();
                Arm.OpenGripper();
            })).whenReleased(Takepiece);


    }}

