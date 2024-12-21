package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

public class RutineTakePIece extends SequentialCommandGroup {
    public RutineTakePIece ( arm_Gripper arm){

        addCommands(
       new InstantCommand(arm::Gripperoffset),
        new WaitCommand(100),
        new InstantCommand(arm::armOffset));
    }
}
