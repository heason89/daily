package com.example.daily.service.ifs;

import com.example.daily.vo.*;

public interface ExerciseService {
	
	public BasicRes fillInExercise(ExerciseReq req);
	
	public BasicRes updateExercise(UpdateExerciseReq req);

	public BasicRes deleteExercise(DeleteExerciseReq req);
	
	public GetExerciseRes getExercise(GetUserDataReq req);

	public GetExerciseRes getCalendarExercise(GetUserDataReq req);
	
	public GetExerciseRes getDateExercise(GetDateExerciseReq req);
}
