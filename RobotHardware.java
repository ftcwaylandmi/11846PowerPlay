package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotHardware {

    HardwareMap hwMap;

    public DcMotor rightMotor = null;
    public DcMotor leftMotor = null;

    public DcMotor eleMotor = null;
    public DcMotor rotateMotor = null;

    public Servo grabServo = null;

    public void Init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        rightMotor = hwMap.get(DcMotor.class, "rightMotor");
        leftMotor = hwMap.get(DcMotor.class, "leftMotor");

        leftMotor.setPower(0);
        rightMotor.setPower(0);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        eleMotor = hwMap.get(DcMotor.class, "eleMotor");
        eleMotor.setPower(0);
        eleMotor.setTargetPosition(0);
        eleMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rotateMotor = hwMap.get(DcMotor.class, "rotateMotor");
        rotateMotor.setPower(0);
        rotateMotor.setTargetPosition(0);
        rotateMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        grabServo = hwMap.get(Servo.class,"grabServo");
        grabServo.setDirection(Servo.Direction.FORWARD);
    }

}
