package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

@Autonomous(name="AutonomousRight", group="11846")
public class AutonomousRight extends LinearOpMode {

    private Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.InitHardware(hardwareMap);
        waitForStart();

        int distFromWallInit = 2;

        if(opModeIsActive()){

            // 10.8 inches for turn equals 90 degrees
            // 5.4 inches for turn equals 45 degrees

            robot.GrabServoClose();
            sleep(1000);
            robot.EleMotorTicksAuton(1);



            robot.DriveByInches(.5, 22-distFromWallInit);
            sleep(1000);
            int x = 0;
            for(int i = 0; i<6; i++){
                x = x + robot.GetColor();
            }
            int test = 0;
            int savedpos  = Math.round(x/5);
            telemetry.addData("Color", savedpos);
            telemetry.update();

            robot.DriveByInches(.25, 13);
            robot.DriveByInches(.35,-9.3);
            robot.TurnByInches(.2,59,'l');
            robot.EleMotorTicksAuton(4);
            robot.DriveByInches(.5,19);
            sleep(500);
            robot.GrabServoOpen();
            sleep(500);

            if(savedpos == 1){
                robot.DriveByInches(.5, -4);
                robot.TurnByInches(.2, 30,'l');
            }

            if (savedpos == 2) {
                robot.DriveByInches(.5, -20);
                robot.TurnByInches(.2,57,'r');
            }

            if (savedpos == 3) {
                robot.DriveByInches(.5, -10);
                robot.TurnByInches(.2,40,'l');
                robot.DriveByInches(.5,-50);
            }

                robot.EleMotorTicksAuton(0);

        }




    }
}
