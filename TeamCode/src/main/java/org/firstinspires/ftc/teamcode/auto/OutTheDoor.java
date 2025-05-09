package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

@Autonomous
public class OutTheDoor extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new Drive(hardwareMap);

        Path thePath = drive.PathBuilder(new Vector2D(0, 0))
                .translationalScale(0.5)
                .point(new Vector2D(0, 150))
                .point(new Vector2D(110, 150))
                .point(new Vector2D(110, 245))
                .build();

        waitForStart();

        thePath.run();
    }
}
