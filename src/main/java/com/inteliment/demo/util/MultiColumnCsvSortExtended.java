package com.inteliment.demo.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MultiColumnCsvSortExtended
{
    private static final String COLUMN_SEPARATOR = ",";

   

    public static List<List<String>> readCsv(
        InputStream inputStream) throws IOException
    {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(inputStream));
        List<List<String>> lines = new ArrayList<List<String>>();

        String line = null;

        // Skip header
        line = reader.readLine();

        while (true)
        {
            line = reader.readLine();
            if (line == null)
            {
                break;
            }
            List<String> list = Arrays.asList(line.split(COLUMN_SEPARATOR));
            lines.add(list);
        }
        return lines;
    }

    public static void writeCsv(
        String header, List<List<String>> lines, OutputStream outputStream) 
        throws IOException
    {
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(header+"\n");
        for (List<String> list : lines)
        {
            for (int i = 0; i < list.size(); i++)
            {
                writer.write(list.get(i));
                if (i < list.size() - 1)
                {
                    writer.write(COLUMN_SEPARATOR);
                }
            }
            writer.write("\n");
        }
        writer.close();

    }

    @SafeVarargs
	public
    static <T> Comparator<T>
        createComparator(Comparator<? super T>... delegates)
    {
        return (t0, t1) -> 
        {
            for (Comparator<? super T> delegate : delegates)
            {
                int n = delegate.compare(t0, t1);
                if (n != 0)
                {
                    return n;
                }
            }
            return 0;
        };
    }

    public static <T extends Comparable<? super T>> Comparator<List<T>>
        createAscendingComparator(int index)
    {
        return createListAtIndexComparator(Comparator.naturalOrder(), index);
    }

    public static <T extends Comparable<? super T>> Comparator<List<T>>
        createDesendingComparator(int index)
    {
        return createListAtIndexComparator(Comparator.reverseOrder(), index);
    }

    public static <T> Comparator<List<T>>
        createListAtIndexComparator(Comparator<? super T> delegate, int index)
    {
        return (list0, list1) -> 
            delegate.compare(list0.get(index), list1.get(index));
    }

}