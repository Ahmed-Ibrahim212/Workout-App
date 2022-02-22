package com.example.workoutapp

class Constant {
    companion object{
        fun defaultExerciseList():ArrayList<ExerciseModel>{
            val  exerciseList = ArrayList<ExerciseModel>()

            val jumping = ExerciseModel(1, "Jumping Jacks",
                R.drawable.jumpingjack,
                false,false)
            exerciseList.add(jumping)

            val wallSit = ExerciseModel(2,"Wall Sit", R.drawable.wallsit, false,false)
            exerciseList.add(wallSit)

            val pushUp = ExerciseModel(3,"Push Up", R.drawable.pushup,false,false)
            exerciseList.add(pushUp)

            val abdominal = ExerciseModel(4,"Abdominal Crunch", R.drawable.abdominal,false,false)
            exerciseList.add(abdominal)

            val stepUpOnChair = ExerciseModel(5,"Step Up On Chair", R.drawable.setonchair,false,false)
            exerciseList.add(stepUpOnChair)

            val squat = ExerciseModel(6, "Squat", R.drawable.squat,false,false)
            exerciseList.add(squat)

            val triceDeepOnChair = ExerciseModel(7,"Trice Deep On Chair",R.drawable.tricedeeponchair,false,false)
            exerciseList.add(triceDeepOnChair)

            val stepUp = ExerciseModel(8,"Step Up",R.drawable.stepup,false,false)
            exerciseList.add(stepUp)

            val plank = ExerciseModel(9,"Plank",R.drawable.kplank,false,false)
            exerciseList.add(plank)

            val highKneels = ExerciseModel(10, "High Kneels Running In Place", R.drawable.highkneels,false,false)
            exerciseList.add(highKneels)

            val lunge = ExerciseModel(11,"Plunge",R.drawable.lunge,false,false)
            exerciseList.add(lunge)

            val workOut = ExerciseModel(12,"Work Out", R.drawable.work,false,false)
            exerciseList.add(workOut)

            return exerciseList
        }
    }
}