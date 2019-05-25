package net.bioknow.pdfcompare;
// Copyright (C) 2001-2019, Foxit Software Inc..
// All Rights Reserved.
//
// http://www.foxitsoftware.com
//
// The following code is copyrighted and contains proprietary information and trade secrets of Foxit Software Inc..
// You cannot distribute any part of Foxit PDF SDK to any third party or general public,
// unless there is a separate license agreement with Foxit Software Inc. which explicitly grants you such rights.
//
// This file contains an example to demonstrate how to use Foxit PDF SDK to compare pdf page with the other.

import com.foxit.sdk.PDFException;
import com.foxit.sdk.common.Library;
import com.foxit.sdk.common.fxcrt.RectF;
import com.foxit.sdk.common.fxcrt.PointF;
import com.foxit.sdk.common.fxcrt.RectFArray;
import com.foxit.sdk.common.Image;
import com.foxit.sdk.pdf.PDFDoc;
import com.foxit.sdk.pdf.PDFPage;
import com.foxit.sdk.addon.CompareResultInfo;
import com.foxit.sdk.addon.CompareResultInfoArray;
import com.foxit.sdk.addon.CompareResults;
import com.foxit.sdk.addon.Comparsion;
import com.foxit.sdk.common.DateTime;
import com.foxit.sdk.pdf.annots.Annot;
import com.foxit.sdk.pdf.annots.Highlight;
import com.foxit.sdk.pdf.annots.Stamp;
import com.foxit.sdk.pdf.annots.QuadPoints;
import com.foxit.sdk.pdf.annots.QuadPointsArray;

import java.io.File;
import java.util.Date;
import java.util.Calendar;
import java.util.Random;

import static com.foxit.sdk.common.Constants.e_ErrSuccess;

public class PDFCompare {


    private static String key = "8f0YFUGMvRkN+ddwhrBxubRL9X8Gz2ILMKj89/LgWFyZht2edOLVYBXLa3eQ0pNoEcmFuencjBuGoM2G0Zfoh78AjrDnyeP3rw8tCASOl/n9O9Y0/bFc+It68U/B6StUKvs4kJIWDLulvmq56mM0qYLh2l5u4A+LcJ222OCFduL6GXd2J9ddhX+ZicD92M9jWsageiwUvbvtZKvIQLTPBpXOOWmoO6YvNW4zX5psr3ZW5dOsvxQEaNwyRdyQIWbOENITh4XE+GdWA+6mzeONBC98CgP2TAHW/B40gwRUtamzxNcS5htGh8kPwaz4XjtR0nI5dIdrUhmtFyUK1R4d53tfWvjVV9CKT2BZg8lYJUwRbvwfdyjDT7wchCcdvskZNuQQ0kjgE2a00CK2bmDUgKds1rljjwowQWasiGpLbv5rYlaBlpozzNTS/Bxj1lxoL82wS3l4mCn2QKbq7waYdBDP7/6YdvLue33kyRjL1D2jQ2f/jab99WdbVWYNnbR3CR4dsm2KAGZPSuScJgcwojbJxyC+0XgUWp7LexXAt9mJaeKKsQFP2NBHPw4cF1cqeipkmgX+4yIpFyl6+2WzymjywE96A8YOXPWIV1kUWeHm0MwrAe12qg3bPl8SgrTn0R1mtXRzyy7xhDe8g20BbIsSVcUmz8rNQaMLzoEOYkRY9suaTaqZ+Av7oYdGy0Tg5lXJUXayNsIL2b6rUZf09b2Wm0k8Bu0kYu4UbAwzRaXA86i9UMPc4rn6h6VtlbfXoPWx9vXqBKj+VDTIp2KKLfs+fq3F7RNxArfFyX6LR2mltPBCHGFAeDOUlh4QEqUMxZk4wysTDivohQU8w8JpJHPjpTooTh58RypOHYvBCii77TzQEwkygC52j2pe6qxCRXHhVxWLbIDMdAuH/k3jAnU0Kqs8wu5Ny6X45BxsxaShFORVjCIxPOnbIZ8xfM+wBghdaFXrPsXEXCOxjILaU0juttUDW7ejb+MzgU1hfXsYSag4KFliDAt2dErAQm8O81XsEAAORnQQHrecpPeb4ZY/uHy7RaBax8caopX+dM4K1GZVCxcEG0FuhROa0GpsCwo21wtV8Q2ZTaYXmgF+hcvFs++l2PQDSatrjFw5jfyp5031LAVvJD5rDgm3tLOzyxWoNHtRngbt1i+C1krNHjpfTIpxulFMEOdODmBq2SHN04AnYSlGXWD9wqFxHFbuQM+j+MdjfGiuhEpy21CBBeQV4Yh15UYVLr/0CCYLn3cBrMJCiYur";
    private static String sn = "tCyNOFHyh5Y1hFlUkfaQwDrctZ2MB8sVpkmpKxC6xtn0N5fXCpLGHw==";
    private static String output_path = "C:\\Users\\bioknow\\Desktop\\output_files\\pdfcompare\\";
    private static String input_path = "C:\\Users\\bioknow\\Desktop\\input_files\\";


    private static void createResultFolder(String output_path) {
        File myPath = new File(output_path);
        if (!myPath.exists()) {
            myPath.mkdir();
        }
    }

    public static void main(String[] args) throws PDFException {
        createResultFolder(output_path);
        // Initialize library
        int error_code = Library.initialize(sn, key);
        if (error_code != e_ErrSuccess) {
            System.out.println("Library Initialize Error: " + error_code);
            return;
        }

        String input_base_file = input_path + "pdfcompare/test_base.pdf";
        String input_compared_file = input_path + "pdfcompare/test_compared.pdf";
        try {
            PDFDoc base_doc = new PDFDoc(input_base_file);
            error_code = base_doc.load(null);
            if (error_code != e_ErrSuccess) {
                System.out.println("The Doc " + input_base_file + " Error: " + error_code);
                return;
            }

            PDFDoc compared_doc = new PDFDoc(input_compared_file);
            error_code = compared_doc.load(null);
            if (error_code != e_ErrSuccess) {
                System.out.println("The Doc " + input_compared_file + " Error: " + error_code);
                return;
            }
            
            Comparsion comparsion = new Comparsion(base_doc, compared_doc);
            comparsion.isEmpty();
            CompareResults result = comparsion.doCompare(0, 0, Comparsion.e_CompareTypeText);
            CompareResultInfoArray oldInfo = result.getOld_info();
            CompareResultInfoArray newInfo = result.getNew_info();
            long oldInfoSize = oldInfo.getSize();
            long newInfoSize = newInfo.getSize();
            PDFPage page = compared_doc.getPage(0);
            for (int i=0; i<newInfoSize; i++)
            {
                CompareResultInfo item = newInfo.getAt(i);
                int type = item.getType();
                if (type == CompareResultInfo.e_CompareResultTypeDeleteText)
                {
                    String res_string;
                    res_string = String.format("\"%s\"", item.getDiff_contents());
                    CreateDeleteTextStamp(page, item.getRect_array(), 0xff0000, res_string, "Compare : Delete", "Text");
                }
                else if (type == CompareResultInfo.e_CompareResultTypeInsertText)
                {
                    String res_string;
                    res_string = String.format("\"%s\"", item.getDiff_contents());
                    CreateHighlightRect(page, item.getRect_array(), 0x0000ff, res_string, "Compare : Insert", "Text");
                }
                else if (type == CompareResultInfo.e_CompareResultTypeReplaceText)
                {
                    String res_string;
                    res_string = String.format("[Old]: \"%s\"\r\n[New]: \"%s\"", oldInfo.getAt(i).getDiff_contents(), item.getDiff_contents());
                    CreateHighlightRect(page, item.getRect_array(), 0xe7651a, res_string, "Compare : Replace", "Text");
                }

            }
            
            compared_doc.saveAs(output_path + "result.pdf", PDFDoc.e_SaveFlagNormal);
            System.out.println("Pdf compare test.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Library.release();
    }

    private static String RandomUID() {
		String uuid = "";
		String temp = "0123456789qwertyuiopasdfghjklzxcvbnm";

		for (int n = 0; n < 16; n++) {
			String uuid_temp;
			Random random = new Random();
			int b = random.nextInt() % 255;

			switch (n) {
			case 6:
				uuid_temp = String.format("4%x", b % 15);
				break;
			case 8:
				int index = random.nextInt() % temp.length();
				if (index < 0)
					index = (-1) * index;
				uuid_temp = String.format("%c%x", temp.charAt(index), b % 15);
				break;
			default:
				uuid_temp = String.format("%02x", b);
				break;
			}
			uuid += uuid_temp;

			switch (n) {
			case 3:
			case 5:
			case 7:
			case 9:
				uuid += '-';
				break;
			}
		}
		return uuid;
	}

	static DateTime GetLocalDateTime() {
		Calendar c = Calendar.getInstance();

		DateTime datetime = new DateTime();
		datetime.setYear(c.get(Calendar.YEAR));
		datetime.setMonth(c.get(Calendar.MONTH) + 1);
		datetime.setDay(c.get(Calendar.DATE));
		datetime.setHour(c.get(Calendar.HOUR));
		datetime.setMinute(c.get(Calendar.MINUTE));
		datetime.setSecond(c.get(Calendar.SECOND));
		
		java.util.TimeZone timeZone = c.getTimeZone();
		int offset = timeZone.getRawOffset();
		int gmt = offset/(3600*1000);
		
		datetime.setUtc_hour_offset((short)gmt);
		datetime.setUtc_minute_offset(offset%(3600*1000) / 60);

		return datetime;
    }
    
    static void CreateHighlightRect(PDFPage page, RectFArray rects, int color, String csContents, String csType, String csObjType) throws PDFException
    {
        Highlight highlight = new Highlight(page.addAnnot(Annot.e_Highlight, new RectF()));
        highlight.setContent(csContents);
    
        QuadPointsArray quad_points_array = new QuadPointsArray();
        int rectSize = rects.getSize();
        for (int i=0; i<rectSize; i++)
        {
            RectF item = rects.getAt(i);
            QuadPoints quad_points = new QuadPoints();
            quad_points.setFirst(new PointF(item.getLeft(), item.getTop()));
            quad_points.setSecond(new PointF(item.getRight(), item.getTop()));
            quad_points.setThird(new PointF(item.getLeft(), item.getBottom()));
            quad_points.setFourth(new PointF(item.getRight(), item.getBottom()));
            quad_points_array.add(quad_points);
        }
        highlight.setQuadPoints(quad_points_array);
    
        highlight.setBorderColor(color);
        highlight.setSubject(csObjType);
        highlight.setTitle(csType);
        highlight.setCreationDateTime(GetLocalDateTime());
        highlight.setModifiedDateTime(GetLocalDateTime());
        highlight.setUniqueID(RandomUID());
    
        highlight.resetAppearanceStream();
    }

    static void CreateDeleteTextStamp(PDFPage page, RectFArray rects, int color, String csContents, String csType, String csObjType) throws PDFException
    {
        RectF rcStamp = new RectF();
        int rectSize = rects.getSize();
        if (rectSize > 0)
        {
            RectF item = rects.getAt(0);
            rcStamp.setLeft(item.getLeft());
            rcStamp.setTop(item.getTop() + 12);
            rcStamp.setRight(rcStamp.getLeft() + 9);
            rcStamp.setBottom(rcStamp.getTop() - 12);
        }
    
        Image pImage = new Image(input_path + "pdfcompare/delete_stamp.png");
    
        Stamp stamp = new Stamp(page.addAnnot(Annot.e_Stamp, rcStamp));
        stamp.setContent(csContents);
        stamp.setBorderColor(color);
        stamp.setSubject(csObjType);
        stamp.setTitle(csType);
        stamp.setCreationDateTime(GetLocalDateTime());
        stamp.setModifiedDateTime(GetLocalDateTime());
        stamp.setUniqueID(RandomUID());
        stamp.setImage(pImage, 0, 0);
    
        stamp.resetAppearanceStream();
    }
}
