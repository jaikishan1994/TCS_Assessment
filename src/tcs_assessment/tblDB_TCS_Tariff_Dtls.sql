USE [DB_TCS]
GO

/****** Object:  Table [dbo].[tblDB_TCS_Tariff_Dtls]    Script Date: 05-Mar-18 9:08:07 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tblDB_TCS_Tariff_Dtls](
	[Tariff_Id] [int] NOT NULL,
	[Tariff_NAme] [varchar](25) NULL,
	[Plan_Type] [varchar](50) NULL,
	[Charge] [numeric](5, 2) NULL,
	[Validity] [date] NULL,
 CONSTRAINT [PK_tblDB_TCS_Tariff_Dtls] PRIMARY KEY CLUSTERED 
(
	[Tariff_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[tblDB_TCS_Tariff_Dtls]  WITH CHECK ADD CHECK  (([Plan_Type]='Prepaid' OR [Plan_Type]='Postpaid'))
GO