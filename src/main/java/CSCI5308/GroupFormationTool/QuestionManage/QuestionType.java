package CSCI5308.GroupFormationTool.QuestionManage;

public enum QuestionType
{

	TEXT
	{
		public String toString()
		{
		   return "TEXT";
		}
	},
	NUMERIC
	{
		public String toString()
		{
		   return "NUMERIC";
		}
	},
	MCQONE
	{
		public String toString()
		{
		   return "MCQONE";
		}
	},
	MCQMULTIPLE
	{
		public String toString()
		{
		   return "MCQMULTIPLE";
		}
	}
	
}

