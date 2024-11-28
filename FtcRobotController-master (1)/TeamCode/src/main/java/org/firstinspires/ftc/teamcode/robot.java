package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.gamepad.GamepadEx;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import java.util.Collections;
import java.util.Set;


@TeleOp(name = " tlaxcala")
public class robot extends OpMode
{
  public GamepadEx ps4;
  private powertrain drivetrain;




        @Override
        public void init() {
            drivetrain = new powertrain(hardwareMap);
            ps4 = new GamepadEx(gamepad1);

        }

        @Override
        public void init_loop() {



        }



        @Override
        public void start() {

        }

        @Override
        public void loop() {

            ps4.readButtons();
            drivetrain.inputcontrol(ps4);
            drivetrain.arcade();

        }


    }

