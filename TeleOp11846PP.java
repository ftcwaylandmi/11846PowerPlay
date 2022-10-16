package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp22154PP", group = "22154")
public class TeleOp11846PP extends OpMode{

    Robot robot = new Robot();

    double leftDrive = 0.00;
    double rightDrive = 0.00;

    double eleDrive = 0.00;
    double rotateDrive = 0.00;

    @Override
    public void init(){robot.InitHardware(hardwareMap);}
    @Override
    public void loop(){
        leftDrive = -gamepad1.left_stick_y;
        rightDrive = -gamepad1.right_stick_y;

        eleDrive = -gamepad2.left_stick_y;
        rotateDrive = -gamepad2.right_stick_x;

        robot.LeftDriveMotor(leftDrive);
        robot.RightDriveMotor(rightDrive);

        robot.EleMotorStick(eleDrive);
        robot.RotateMotorStick(rotateDrive);

        if(gamepad2.left_bumper){
            robot.GrabServoOpen();
        }
        if(gamepad2.right_bumper){
            robot.GrabServoClose();
        }

        telemetry.addData("EleTicks",robot.ElePos());
        telemetry.update();
    }
}
